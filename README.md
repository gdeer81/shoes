# Ecommerce Shoe Store made with Precept

In two terminals:
1. `lein run`
2. `lein figwheel`

The first command starts an http-kit server on port 1337. The second will build the client.

The app will be visible at http://localhost:1337

There is an nREPL server on 7000 for the server
## The server
Provides a REST interface and pushes data to precept via socket

## The client
The client uses reagent for the view

cljs-http for making REST calls and sente for the socket connection.