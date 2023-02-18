package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.enums.VoteCategory;
import cameleoon.trial.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/{quoteId}")
    public VoteResponseDto vote(@PathVariable Long quoteId, VoteCategory voteCategory) {
        return voteService.addVote(quoteId, voteCategory);
    }

    @GetMapping
    public List<VoteResponseDto> getVotes() {
        return voteService.getVotes();
    }


}
