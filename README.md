# CS302-Java-2020-Group1
group 1, partII java, COMPSYS302, 2020 s1 

Strumento is an app for selling second-hand instruments (acoustic and electric guitars, pianos, ukuleles, and drums). The app was developed using Java in Android Studio. It allows the user to view the details of the instruments, as well as search through our instrument database by brand, colour, location, and seller.

The following Java and XML files make up the back-end of our app:
- Instrument.java
  Contains our Instrument class and child classes which represent the categories of instruments being sold on the app.
- InstrumentProvider.java
  Simulates fetching data from our static 'database' of 50 instruments (5 categories of instruments, 10 instruments per         category).
- InstrumentAdapter.java
  Adpats the instrument data to the ListView in activity_list.xml, the layout file responsible for the ListActivity for each category of         instrument.
- MainActivity.java
  Handles the back-end of the front-page of the app. Contains a RecyclerView for displaying a "Top Pick" (most viewed           instrument) from each category and a list of the categories from which all instruments in a particular category can be         viewed in the ListAcitivty.
- ListAcitivty.java
  Handles the back-end of the list of a instruments of a particular category. Contains a ListView populated by                   InstrumentAdapter.java which can be interacted with to view a selected instrument in the DetailAcvitiy.
- DetailActivity.java
  Handles the back-end of the detailed view of an instrument after it has been selected from the list of instruments in its     category or from the "Top Picks" section of the MainActivity.
- TopPicksAdapter.java
  Adapts the most viewed instruments to a RecyclerView in the MainActivity.
- activity_main.xml
  Layout file for the MainActivity.
- activity_list.xml
  Layout file for the ListActivity.
- activity_detail.xml
  Layout file for the DetailActivity.
- instrument_list_view_item.xml
  Layout for the card of one instrument in the ListActivity.
- top_picks_item.xml
  Layout for the card of one instrument in the "Top Picks" section of MainActivity.
  
