package jp.co.soramitsu.iroha2.scale.writer.expression;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;
import jp.co.soramitsu.iroha2.model.expression.Not;

import java.io.IOException;

public class NotWriter implements ScaleWriter<Not> {

    private static final ExpressionWriter EXPRESSION_WRITER = new ExpressionWriter();

    @Override
    public void write(ScaleCodecWriter writer, Not value) throws IOException {
        writer.write(EXPRESSION_WRITER, value.getExpression());
    }

}
