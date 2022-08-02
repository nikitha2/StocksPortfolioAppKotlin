# StocksPortfolioAppKotlin

https://user-images.githubusercontent.com/23514932/182270048-3e64eae0-e570-4326-9273-42bb1b222697.mov

# The architectural approach you took and why
- Used MVVM architecture. This allows us to keep code modular and reusable. Viewmodals help in cacahing the data. In cases when phone configuration changed and view is recreated. We do not have to make the network call again as data is cached in the view modal.
- MVVM architecture keeps code modular. This enables us to test each module seperatly.
- The project is even easier to maintain and scale
- Furture divided the directories feature wise. This helps when we try to scale the app and add more features.

# The trade offs you made and why
- 

# How to run your project


# 3rd party libraries or copied code you may have used
- Retrofit to make network calls

