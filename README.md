## Usage

#### 1. Create a CuteProvider

The MomWidget displays Cute objects, which consist of an image, name, and something to be said to mom. Extend CuteProvider class and have it create the Cute objects you want. I have included a demo TestCuteProvider.java.

#### 2. Modify MomWidgetProvider

Decide how often which CuteProviders get used in the getRandomCute() method. Be sure to add these to the cute ArrayList<CuteProvider> or choose your own way of doing so.

note: Limited to one update per 30 minutes by android (to alter this, heavier code modification is required). Add a widget preview in momwidget_provider.xml. Change the icon in AndroidManifest.xml.
