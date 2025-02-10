// import { useState, useEffect } from "react";
// import { Client } from "@stomp/stompjs";

// const ScheduleMessage = () => {
//     const [message, setMessage] = useState("");
//     const [dateTime, setDateTime] = useState("");
//     const [scheduledMessages, setScheduledMessages] = useState([]);
//     const [client, setClient] = useState(null);

//     useEffect(() => {
//         fetchScheduledMessages();
//         setupWebSocket();
//     }, []);

//     // Function to fetch all scheduled messages
//     const fetchScheduledMessages = async () => {
//         try {
//             const response = await fetch("http://localhost:8080/api/messages/all");
//             const data = await response.json();
//             setScheduledMessages(data);
//         } catch (error) {
//             console.error("Error fetching messages:", error);
//         }
//     };

//     // Function to setup WebSocket connection
//     const setupWebSocket = () => {
//         const stompClient = new Client({
//             brokerURL: "ws://localhost:8080/ws",
//             onConnect: () => {
//                 console.log("Connected to WebSocket");
//                 stompClient.subscribe("/topic/messages", (message) => {
//                     const newMessage = JSON.parse(message.body);
//                     setScheduledMessages((prevMessages) => [...prevMessages, newMessage]);
//                 });
//             },
//             onStompError: (frame) => {
//                 console.error("WebSocket Error:", frame);
//             }
//         });

//         stompClient.activate();
//         setClient(stompClient);
//     };



//     // Function to handle form submission
//     const handleSubmit = async (e) => {
//         e.preventDefault();
//         const data = { message, scheduledTime: dateTime };

//         try {
//             const response = await fetch("http://localhost:8080/api/messages/schedule", {
//                 method: "POST",
//                 headers: { "Content-Type": "application/json" },
//                 body: JSON.stringify(data),
//             });

//             if (response.ok) {
//                 alert("Message Scheduled Successfully!");
//                 fetchScheduledMessages();
//                 setMessage("");
//                 setDateTime("");
//             } else {
//                 alert("Failed to Schedule Message");
//             }
//         } catch (error) {
//             console.error("Error scheduling message:", error);
//         }
//     };

//     return (
//         <div>
//             <h2>Schedule a Message</h2>
//             <form onSubmit={handleSubmit}>
//                 <textarea 
//                     value={message} 
//                     onChange={(e) => setMessage(e.target.value)} 
//                     placeholder="Enter your message" 
//                 /><br />
                
//                 <input 
//                     type="datetime-local" 
//                     value={dateTime} 
//                     onChange={(e) => setDateTime(e.target.value)} 
//                 /><br />
                
//                 <button type="submit">Schedule</button>
//             </form>

//             <h3>Scheduled Messages</h3>
//             <ul>
//                 {scheduledMessages.map((msg) => (
//                     <li key={msg.id}>
//                         <strong>Message:</strong> {msg.message} <br />
//                         <strong>Scheduled Time:</strong> {new Date(msg.scheduledTime).toLocaleString()} <br />
//                         <strong>Status:</strong> {msg.sent ? "Sent ✅" : "Pending ⏳"}
//                     </li>
//                 ))}
//             </ul>
//         </div>
//     );
// };

// export default ScheduleMessage;


// import { useState, useEffect } from "react";
// import { Client } from "@stomp/stompjs";

// const ScheduleMessage = () => {
//     const [message, setMessage] = useState("");
//     const [dateTime, setDateTime] = useState("");
//     const [scheduledMessages, setScheduledMessages] = useState([]);
//     const [client, setClient] = useState(null);

//     useEffect(() => {
//         fetchScheduledMessages();
//         setupWebSocket();
//     }, []);

//     // Function to fetch all scheduled messages
//     const fetchScheduledMessages = async () => {
//         try {
//             const response = await fetch("http://localhost:8080/api/messages/all");
//             const data = await response.json();


//             console.log("data------",data);
            
//             setScheduledMessages(data);
//         } catch (error) {
//             console.error("Error fetching messages:", error);
//         }
//     };

//     // Function to setup WebSocket connection
//     const setupWebSocket = () => {
//         const stompClient = new Client({
//             brokerURL: "ws://localhost:8080/ws",
//             onConnect: () => {
//                 console.log("Connected to WebSocket");

//                 stompClient.subscribe("/topic/messages", (message) => {
//                     const updatedMessage = JSON.parse(message.body);
//                     console.log("🔔 Message Update Received:", updatedMessage);

//                     setScheduledMessages((prevMessages) => {
//                         return prevMessages.map((msg) =>
//                             msg.id === updatedMessage.id ? updatedMessage : msg
//                         );
//                     });
//                 });
//             },
//             onStompError: (frame) => {
//                 console.error("WebSocket Error:", frame);
//             }
//         });

//         stompClient.activate();
//         setClient(stompClient);
//     };

//     // Function to handle form submission
//     const handleSubmit = async (e) => {
//         e.preventDefault();
//         const data = { message, scheduledTime: dateTime };

//         try {
//             const response = await fetch("http://localhost:8080/api/messages/schedule", {
//                 method: "POST",
//                 headers: { "Content-Type": "application/json" },
//                 body: JSON.stringify(data),
//             });


//             console.log("rseponse",response);
            

//             if (response.ok) {
//                 alert("Message Scheduled Successfully!");
//                 fetchScheduledMessages();
//                 setMessage("");
//                 setDateTime("");
//             } else {
//                 alert("Failed to Schedule Message");
//             }
//         } catch (error) {
//             console.error("Error scheduling message:", error);
//         }
//     };

//     return (
//         <div>
//             <h2>Schedule a Message</h2>
//             <form onSubmit={handleSubmit}>
//                 <textarea 
//                     value={message} 
//                     onChange={(e) => setMessage(e.target.value)} 
//                     placeholder="Enter your message" 
//                 /><br />
                
//                 <input 
//                     type="datetime-local" 
//                     value={dateTime} 
//                     onChange={(e) => setDateTime(e.target.value)} 
//                 /><br />
                
//                 <button type="submit">Schedule</button>
//             </form>

//             <h3>Scheduled Messages</h3>
//             <ul>
//                 {scheduledMessages.map((msg) => (
//                     <li key={msg.id}>
//                         <strong>Message:</strong> {msg.message} <br />
//                         <strong>Scheduled Time:</strong> {new Date(msg.scheduledTime).toLocaleString()} <br />
//                         <strong>Status:</strong> {msg.sent ? "✅ Sent" : "⏳ Pending"}
//                     </li>
//                 ))}
//             </ul>
//         </div>
//     );
// };

// export default ScheduleMessage;



import { useState, useEffect } from "react";
import { Client } from "@stomp/stompjs";

const ScheduleMessage = () => {

    const [message, setMessage] = useState("");
    const [dateTime, setDateTime] = useState("");
    const [scheduledMessages, setScheduledMessages] = useState([]);
    const [client, setClient] = useState(null);

    useEffect(() => {
        fetchScheduledMessages();
        setupWebSocket();

        return () => {
            if (client) {
                client.deactivate();
                console.log("🔌 WebSocket Disconnected");
            }
        };
    }, []);

    const fetchScheduledMessages = async () => {
        try {
            const response = await fetch("http://localhost:8080/api/messages/all", {
                method: "GET",
                credentials: "include",  // ✅ Ensures cookies/auth headers are sent
                headers: {
                    "Content-Type": "application/json",
                },
            });
    
            if (!response.ok) {
                throw new Error(`Failed to fetch messages: ${response.status} ${response.statusText}`);
            }
    
            const data = await response.json();
            setScheduledMessages(data);
        } catch (error) {
            console.error("⚠️ Error fetching messages:", error);
        }
    };
    

    // ✅ Setup WebSocket connection
    const setupWebSocket = () => {
        const stompClient = new Client({
            brokerURL: "ws://localhost:8080/ws",
            reconnectDelay: 5000,  // ✅ Auto-reconnect if connection fails
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
            onConnect: () => {
                console.log("✅ Connected to WebSocket");

                stompClient.subscribe("/topic/messages", (message) => {
                    const updatedMessage = JSON.parse(message.body);
                    console.log("🔔 Message Update Received:", updatedMessage);

                    setScheduledMessages((prevMessages) => {
                        const exists = prevMessages.some(msg => msg.id === updatedMessage.id);
                        return exists
                            ? prevMessages.map(msg => msg.id === updatedMessage.id ? updatedMessage : msg)
                            : [...prevMessages, updatedMessage];
                    });
                });
            },
            onStompError: (frame) => {
                console.error("❌ WebSocket Error:", frame);
            },
            onDisconnect: () => {
                console.log("🔌 WebSocket Disconnected");
            }
        });

        stompClient.activate();
        setClient(stompClient);
    };

    // ✅ Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        const data = { message, scheduledTime: dateTime };

        try {
            const response = await fetch("http://localhost:8080/api/messages/schedule", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data),
            });

            if (response.ok) {
                alert("✅ Message Scheduled Successfully!");
                fetchScheduledMessages();
                setMessage("");
                setDateTime("");
            } else {
                alert("⚠️ Failed to Schedule Message");
            }
        } catch (error) {
            console.error("⚠️ Error scheduling message:", error);
        }
    };

    return (
        <div>
            <h2>📩 Schedule a Message</h2>
            <form onSubmit={handleSubmit}>
                <textarea
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                    placeholder="Enter your message"
                    required
                />
                <br />
                <input
                    type="datetime-local"
                    value={dateTime}
                    onChange={(e) => setDateTime(e.target.value)}
                    required
                />
                <br />
                <button type="submit">📅 Schedule</button>
            </form>

            <h3>📜 Scheduled Messages</h3>
            <ul>
                {scheduledMessages.length === 0 ? (
                    <p>🚫 No messages scheduled.</p>
                ) : (
                    scheduledMessages.map((msg) => (
                        <li key={msg.id}>
                            <strong>📝 Message:</strong> {msg.message} <br />
                            <strong>📅 Scheduled Time:</strong> {new Date(msg.scheduledTime).toLocaleString()} <br />
                            <strong>📬 Status:</strong> {msg.sent ? "✅ Sent" : "⏳ Pending"}
                        </li>
                    ))
                )}
            </ul> 
        </div>
    );
};

export default ScheduleMessage;



