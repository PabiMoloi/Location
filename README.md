# Location
Location is a simple android application that allows a user to save map markers on a map of places they have visited.

[![CircleCI](https://circleci.com/gh/PabiMoloi/Location.svg?style=svg)](https://circleci.com/gh/PabiMoloi/Location)

# Screenshots
![Screenshot](https://github.com/PabiMoloi/Location/blob/master/app/src/main/splashscreen.png)
![Screenshot](https://github.com/PabiMoloi/Location/blob/master/app/src/main/listview.png)
![Screenshot](https://github.com/PabiMoloi/Location/blob/master/app/src/main/mapview.png)
![Screenshot](https://github.com/PabiMoloi/Location/blob/master/app/src/main/quizview.png)
![Screenshot](https://github.com/PabiMoloi/Location/blob/master/app/src/main/addlocation.png)

# API
- Google Maps API: https://developers.google.com/maps/documentation/android-api/
- Google Places API: https://developers.google.com/places/android-api/

# Setup
1. Download or clone this repo.
2. If you wish to contribute or test the app, you will need to obtain a Google Maps API key. Navigate to https://developers.google.com/maps/documentation/android-api/signup
3. Obtain your API key, change it in the file values/google_maps_api.xml
# Libraries
-Room Persistence Library

# How Location Works
- Adding a location
After the user downloads and launches the application, they will be presented with an empty list screen, as no location has been added.
    1. The user will click on the floating action button.
    2. The application will display the map view screen and show the user's current location on the map.
    3. The user will then have to long press on the location and the application will ask the user if they would like to add a map point.
    4. If the user selects yes, the application will navigate to the add location screen. Once there, the user will be required to enter data about the location (Location name, location type, location's best features, and the number of visits.).
    5. The user will then click on the save button to save the map point. The application will then naviagate to the map view and show the map marker of the newly added location.
    6. If the user selects no, the view stays in the map view screen.
 
- Viewing a saved location
 After the user has added location points on the map.
    1. The user will navigate to the home screen that will display a list of saved map points.
    2. The user will cliok on a location that they wish to view.
    3. The application will navigate to the location details view and display information about the selected location.