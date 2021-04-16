package jp.co.soramitsu.iroha2.scale.writer;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;
import jp.co.soramitsu.iroha2.model.PermissionRaw;

import java.io.IOException;

public class PermissionRawWriter implements ScaleWriter<PermissionRaw> {

    @Override
    public void write(ScaleCodecWriter writer, PermissionRaw value) throws IOException {
        writer.writeAsList(value.getValue());
    }

}
