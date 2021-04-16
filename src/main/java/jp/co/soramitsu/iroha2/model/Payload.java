package jp.co.soramitsu.iroha2.model;

import jp.co.soramitsu.iroha2.model.instruction.Instruction;
import lombok.Data;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Payload {

    @NonNull
    private AccountId accountId;

    @NonNull
    private List<Instruction> instructions = new ArrayList<>();

    // unsigned int 64
    @NonNull
    private BigInteger creationTime;

    // unsigned int 64
    @NonNull
    private BigInteger timeToLiveMs;

    @NonNull
    private Metadata metadata = new Metadata(new HashMap<>());

    public Payload() {
    }

    public Payload(AccountId accountId, BigInteger creationTime,
                   BigInteger timeToLiveMs) {
        this.accountId = accountId;
        this.creationTime = creationTime;
        this.timeToLiveMs = timeToLiveMs;
    }

    public Payload(AccountId accountId, List<Instruction> instructions, BigInteger creationTime,
                   BigInteger timeToLiveMs, Metadata metadata) {
        this.accountId = accountId;
        this.instructions = instructions;
        this.creationTime = creationTime;
        this.timeToLiveMs = timeToLiveMs;
        this.metadata = metadata;
    }
}
