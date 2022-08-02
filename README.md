# StocksPortfolioAppKotlin

https://user-images.githubusercontent.com/23514932/182270048-3e64eae0-e570-4326-9273-42bb1b222697.mov

# The architectural approach you took and why
- Used MVVM architecture. This allows us to keep code modular and reusable. Viewmodals help in cacahing the data. In cases when phone configuration changed and view is recreated. We do not have to make the network call again as data is cached in the view modal.
- MVVM architecture keeps code modular. This enables us to test each module seperatly.
- The project is even easier to maintain and scale
- Furture divided the directories feature wise. This helps when we try to scale the app and add more features.

# The trade offs you made and why
- Decided to go with View modal instead of Jetpack compose. This would increase the apk size. Reason being jetpack compose is still in Beta and making network calls did not seem as straight forward as I hoped.

# How to run your project
- Import project with version control in android studio.
   new->project from version control-> input url: https://github.com/nikitha2/StocksPortfolioAppKotlin.git -> click "clone". This should clone and build the project. 
![Screen Shot 2022-08-01 at 6 18 30 PM](https://user-images.githubusercontent.com/23514932/182271233-d05b635e-c7a8-4d24-b689-d3eb77459cc0.png)

- Select emulatot or physical deice to run the app. Click the run icon
![Screen Shot 2022-08-01 at 6 20 33 PM](https://user-images.githubusercontent.com/23514932/182271461-0f42d8a3-ccb2-40b1-8a76-301fb4d28af2.png)


# 3rd party libraries or copied code you may have used
- Retrofit to make network calls

