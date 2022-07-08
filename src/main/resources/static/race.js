var stompClient = null;



function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
    var socket = new SockJS('/websocket-example');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);

        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/race', function (data) {
//        console.log(JSON.parse(data.body));
            showGreeting(JSON.parse(data.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/race", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
  for(var i=0;i<message.length;i++ ){
    var objectMessage =message[i];
    $("#userinfo").append("<tr><td> GEAR: "+objectMessage.gear
    +", SPEED: "+objectMessage.speed +", CONDITION: "+objectMessage.condition +"</td></tr>");
  }
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});