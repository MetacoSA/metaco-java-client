package helpers;

import com.metaco.api.MetacoClientBuilder;
import com.metaco.api.contracts.InputsToSign;
import com.metaco.api.contracts.TransactionToSign;
import com.subgraph.orchid.encoders.Hex;
import org.bitcoinj.core.*;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.crypto.TransactionSignature;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import org.bitcoinj.utils.BriefLogFormatter;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Map;

public class TestUtils {
    private static final String METACO_ENV_API_URL_NAME = "METACO_ENV_API_URL";
    private static final String METACO_ENV_API_ID_NAME = "METACO_ENV_API_ID";
    private static final String METACO_ENV_API_KEY_NAME = "METACO_ENV_API_KEY";
    private static final String METACO_ENV_WALLET_PRIVATE_KEY_HEX_NAME = "METACO_ENV_WALLET_PRIVATE_KEY_HEX";

    private static String DEFAULT_API_URL = "http://api.testnet.metaco.com/v1/";

    public static MetacoClientBuilder GetMetacoAnonymousClientTestBuilder() {
        Map<String, String> env = System.getenv();

        String apiUrl = env.containsKey(METACO_ENV_API_URL_NAME) ? env.get(METACO_ENV_API_URL_NAME) : DEFAULT_API_URL;

        return new MetacoClientBuilder()
                .withApiUrl(apiUrl)
                .withTestingMode(true);
    }

    public static MetacoClientBuilder GetMetacoAuthenticatedClientTestBuilder() {
        Map<String, String> env = System.getenv();

        String apiUrl = env.containsKey(METACO_ENV_API_URL_NAME) ? env.get(METACO_ENV_API_URL_NAME) : DEFAULT_API_URL;
        String apiId = env.get(METACO_ENV_API_ID_NAME);
        String apiKey = env.get(METACO_ENV_API_KEY_NAME);

        return new MetacoClientBuilder()
                .withApiUrl(apiUrl)
                .withApiId(apiId)
                .withApiKey(apiKey)
                .withTestingMode(true);
    }

    public static String GetBitcoinAddress() {
        Map<String, String> env = System.getenv();
        String walletPrivateKey = env.get(METACO_ENV_WALLET_PRIVATE_KEY_HEX_NAME);

        NetworkParameters networkParameters = NetworkParameters.fromID(NetworkParameters.ID_TESTNET);
        ECKey key = ECKey.fromPrivate(Hex.decode(walletPrivateKey));
        assert networkParameters != null;
        Address addr = key.toAddress(networkParameters);

        return addr.toString();
    }

    public static String GetHexSignedTransaction(TransactionToSign txToSign) {
        BriefLogFormatter.init();
        Context.getOrCreate(NetworkParameters.fromID(NetworkParameters.ID_TESTNET));

        Map<String, String> env = System.getenv();
        String walletPrivateKey = env.get(METACO_ENV_WALLET_PRIVATE_KEY_HEX_NAME);

        NetworkParameters networkParameters = NetworkParameters.fromID(NetworkParameters.ID_TESTNET);
        ECKey key = ECKey.fromPrivate(Hex.decode(walletPrivateKey));
        assert networkParameters != null;
        Address addr = key.toAddress(networkParameters);
        Script scriptPubKey = ScriptBuilder.createOutputScript(addr);

        Transaction tx = new Transaction(networkParameters, Hex.decode(txToSign.getRaw()));

        for(InputsToSign inputsToSign : txToSign.getInputs_to_sign()) {
            Sha256Hash sigHash = tx.hashForSignature(inputsToSign.getIndex(), scriptPubKey, Transaction.SigHash.ALL, false);

            ECKey.ECDSASignature sig = key.sign(sigHash);

            TransactionSignature txSign = new TransactionSignature(sig, Transaction.SigHash.ALL, false);

            Script inputScript = ScriptBuilder.createInputScript(txSign, key);

            tx.getInput(inputsToSign.getIndex()).setScriptSig(inputScript);
        }
        tx.verify();

        return DatatypeConverter.printHexBinary(tx.unsafeBitcoinSerialize());
    }
}
