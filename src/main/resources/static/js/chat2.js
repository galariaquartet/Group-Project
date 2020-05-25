//var buttonChat = document.querySelector('#chat').addEventListener("click", connect); ;
var chatPage = document.querySelector('#chat-page');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var count = 0;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

//xrhsimopoiei SockJS kai th Stomp gia na kanei thn syndesh sto wsEndPoint 
function connect(event) {

    if (count === 0) {
        console.log("EEEEEEEEEEEEEEEEEE");
        username = document.querySelector('#name').value.trim();//painei apo thn input th username k afairei ta kena

        //console.log( username);
        //    if(username) {
        //        usernamePage.classList.add('hidden');

        chatPage.classList.remove('hidden');
        console.log(username);

        var socket = new SockJS('/javatechie'); //einai mesa sto arxeio WsConfig
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
        // }
        count = count + 1;
        event.preventDefault();


        console.log(count);
    }
    //       console.log("GGGGGGGGGGGGGGGGGGG");
    //    username = document.querySelector('#name').value.trim();//painei apo thn input th username k afairei ta kena

    //     chatPage.classList.remove('hidden');
    console.log(username);



    stompClient.connect({}, onConnected, onError);
    // }
    //   event.preventDefault();


}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);  //pairnei th callback sunarthsh opotedhpote ena mnm ftanei sto sugkekrimeno topic 

    // Tell your username to the server
    stompClient.send("/app/chat.register",
            {},
            JSON.stringify({sender: username, type: 'JOIN'})
            )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function send(event) {
    var messageContent = messageInput.value.trim();

    if (messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    var usernameElement = document.createElement('div');
//             usernameElement.classList.add("my_user_name");
    var usernameText = document.createTextNode(message.sender);

    usernameElement.appendChild(usernameText);


    var name = document.querySelector('#name').value;

    if (name === usernameElement.innerHTML) {

        usernameElement.classList.add("username_name_new"); //pros8etoume style stousername


        messageElement.appendChild(usernameElement);

        var textElementDIV = document.createElement('div');
        textElementDIV.classList.add("my_user_mess");

        var textElement = document.createElement('p');

        textElementDIV.appendChild(textElement); //to p(textElement) einai paidi tou div(textElementDIV)

        var messageText = document.createTextNode(message.content);
        textElement.appendChild(messageText); //to keimeno pou grafoume einai paidi tou p

        messageElement.appendChild(textElementDIV);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    } else {
        usernameElement.classList.add("other_user_name_new"); //pros8etoume style stousername


        messageElement.appendChild(usernameElement);

        var textElementDIV = document.createElement('div');
        textElementDIV.classList.add("other_user_mess");

        var textElement = document.createElement('p');

        textElementDIV.appendChild(textElement); //to p(textElement) einai paidi tou div(textElementDIV)

        var messageText = document.createTextNode(message.content);
        textElement.appendChild(messageText); //to keimeno pou grafoume einai paidi tou p

        messageElement.appendChild(textElementDIV);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    }


}

messageForm.addEventListener('submit', send, true);
