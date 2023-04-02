package quotes.app.service;

import quotes.app.api.dto.VoteRequestDto;
import quotes.app.api.dto.VoteResponseDto;

import java.util.List;

public interface VoteService {


    VoteResponseDto addVote(VoteRequestDto request);

    List<VoteResponseDto> getVotes();
}
