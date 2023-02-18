package cameleoon.trial.service;

import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.enums.VoteCategory;

import java.util.List;

public interface VoteService {


    VoteResponseDto addVote(Long quoteId, VoteCategory voteCategory);

    List<VoteResponseDto> getVotes();
}
