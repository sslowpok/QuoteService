package cameleoon.trial.service;

import cameleoon.trial.api.dto.VoteRequestDto;
import cameleoon.trial.api.dto.VoteResponseDto;

import java.util.List;

public interface VoteService {


    VoteResponseDto addVote(VoteRequestDto request);

    List<VoteResponseDto> getVotes();
}
