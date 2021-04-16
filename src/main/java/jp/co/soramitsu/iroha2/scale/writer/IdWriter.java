package jp.co.soramitsu.iroha2.scale.writer;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;
import io.emeraldpay.polkaj.scale.writer.UnionWriter;
import jp.co.soramitsu.iroha2.model.Id;
import jp.co.soramitsu.iroha2.model.IdBox;

import java.io.IOException;

public class IdWriter implements ScaleWriter<Id> {

    private static final UnionWriter<IdBox> ID_BOX_WRITER = new UnionWriter<>(
            new AccountIdWriter(), // 0 - AccountId
            new AssetIdWriter(), // 1 - AssetId
            new DefinitionIdWriter(), // 2 - AssetDefinitionId
            new DomainNameWriter(), // 3 - DomainName
            new PeerIdWriter(), // 4 - PeerId
            new NopWriter<>() // 5 - WorldId
    );

    @Override
    public void write(ScaleCodecWriter writer, Id value) throws IOException {

        writer.write(ID_BOX_WRITER, new EnumerationUnionValue<>(value.getId()));
    }
}
