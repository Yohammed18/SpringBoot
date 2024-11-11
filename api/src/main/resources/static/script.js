
play = async function(clientGesture){
    url = "http://localhost:8080/score/wins"
    result = "wins"

    if(clientGesture == 'rock'){
        result = 'tie'
        url = "http://localhost:8080/score/ties"
    }

    if(clientGesture == 'scissors'){
        result = 'loss'
        url = "http://localhost:8080/score/losses"
    }

    try{

        const response = await fetch(url, {method: "POST"});
        const score = await response.json();

        document.getElementById('wins').innerHTML = "<strong>Wins: </strong> "+ score.wins;
        document.getElementById('ties').innerHTML = "<strong>Ties: </strong> "+ score.ties;
        document.getElementById('losses').innerHTML = "<strong>Losses: </strong> "+ score.losses;
    } catch (error){
        console.error('Error ', error)
    }

    document.getElementById("result").innerHTML = result;
}