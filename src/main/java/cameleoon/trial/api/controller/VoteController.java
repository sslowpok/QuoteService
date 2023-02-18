package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.VoteRequestDto;
import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    @Operation(summary = "Add a vote")
    public VoteResponseDto vote(@RequestBody VoteRequestDto request) {
        return voteService.addVote(request);
    }

    @GetMapping
    @Operation(summary = "Get list of votes")
    public List<VoteResponseDto> getVotes() {
        return voteService.getVotes();
    }


}
