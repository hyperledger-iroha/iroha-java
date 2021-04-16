package jp.co.soramitsu.iroha2.scale.writer.instruction;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;
import jp.co.soramitsu.iroha2.model.instruction.If;
import jp.co.soramitsu.iroha2.scale.writer.expression.ExpressionWriter;

import java.io.IOException;

public class IfWriter implements ScaleWriter<If> {

    private static final ExpressionWriter EXPRESSION_WRITER = new ExpressionWriter();
    private static final InstructionWriter INSTRUCTION_WRITER = new InstructionWriter();

    @Override
    public void write(ScaleCodecWriter writer, If value) throws IOException {
        writer.write(EXPRESSION_WRITER, value.getCondition());
        writer.write(INSTRUCTION_WRITER, value.getThen());
        // optional
        if (value.getOtherwise() == null) {
            writer.directWrite(0);
        } else {
            writer.directWrite(1);
            writer.write(INSTRUCTION_WRITER, value.getOtherwise());
        }
    }
}
