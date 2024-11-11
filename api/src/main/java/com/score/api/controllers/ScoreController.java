package com.score.api.controllers;

import com.score.api.entity.Score;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30,20,10);

    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name = "new-value") int newValue){
        score.setWins(newValue);
        return score;
    }

    @DeleteMapping("/score/delete")
    public void DeleteScore(){
        score = null;
    }

    @PutMapping("/score/reset")
    public Score updateScore(@RequestBody Score updateScore){
        score = updateScore;
        return score;
    }

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Rest API works";
    }

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @GetMapping("/score/{wlt}")
    public int getWinLossOrTie(@PathVariable String wlt){

        if(wlt.equals("wins")) return score.getWins();
        if(wlt.equals("losses")) return score.getLosses();
        return score.getTies();
    }


    @PostMapping("/score/wins")
    public Score increaseWins(){
        score.setWins(score.getWins()+1);
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses(){
        score.setLosses(score.getLosses()+1);
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies(){
        score.setTies(score.getTies()+1);
        return score;
    }


//    @GetMapping("/score/wins")
//    public int getWins(){ return score.getWins(); }
//
//    @GetMapping("/score/wins")
//    public int getTies(){ return score.getTies(); }
//
//    @GetMapping("/score/wins")
//    public int getLoses(){ return score.getLoses(); }



}
