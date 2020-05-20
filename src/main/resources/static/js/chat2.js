//var buttonChat = document.querySelector('#chat').addEventListener("click", connect); ;
var chatPage = document.querySelector('#chat-page');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var count = 0;




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
                event.preventDefault();
            

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

    if (message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        //        var avatarElement = document.createElement('i');
        //        var avatarText = document.createTextNode(message.sender[0]);
        //        avatarElement.appendChild(avatarText);
        //        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        //        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;

}


//function getAvatarColor(messageSender) {
//    var hash = 0;
//    for (var i = 0; i < messageSender.length; i++) {
//        hash = 31 * hash + messageSender.charCodeAt(i);
//    }
//
//    var index = Math.abs(hash % colors.length);
//    return colors[index];
//}

messageForm.addEventListener('submit', send, true);
 