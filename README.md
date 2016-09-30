# CircleIndexView
A Smooth Circular digital indicator with text
##Demo
![images](https://github.com/gaoyuyu/CircleIndexView/raw/master/captures/appgif.gif)

##How to Use

copy `CircleIndexView.java` to your project!

define the view in xml like this:

```xml
    <com.gaoyy.circleindexview.CircleIndexView
        android:id="@+id/circle_index_view"
        android:layout_width="200dp"
        android:layout_height="200dp"
        circleindexview:outCircleColor="@color/circleindexview_out_gray"
        circleindexview:inCircleColor="@color/circleindexview_in_green"
        circleindexview:numberColor="@color/circleindexview_in_green"
        circleindexview:numberTextSize="20sp"
        circleindexview:middleText="Pm25"
        circleindexview:middleTextColor="@color/circleindexview_sub_gray"
        circleindexview:middleTextSize="15sp"
        circleindexview:bottomText="空气污染指数"
        circleindexview:bottomTextColor="@color/circleindexview_main_text"
        circleindexview:bottomTextSize="15sp"
        />
```

the Customized properties are in the follow table:

| Property        | Format           | Default  |
| ------------- |:-------------:| :-----:|
|outCircleColor|color|Color.LTGRAY|
|inCircleColor|color|Color.GREEN|
|numberColor|color|Color.GREEN|
|numberTextSize|dimension|20sp|
|middleText|string|N/A|
|middleTextColor|color|Color.LTGRAY|
|middleTextSize|dimension|15sp|
|bottomText|string||
|bottomTextColor|color|Color.LTGRAY|
|bottomTextSize|dimension|15sp|

This picture will give you guys a more clear explanation.

![images](https://github.com/gaoyuyu/CircleIndexView/raw/master/captures/properties_details.png)

When you want to update data,just do like this:
```Java
circleIndexView.updateIndex(50);
```


##Tips
In order to make CircleIndexView pretty nice,you might be best to set its `layout_width`/`layout_height` attributes an exact value(sp)，and the values of `layout_width` and `layout_height` are equal.(NOTICE. it will be 200sp as default value whether you set `layout_width`/`layout_height` to `match_parent` or `wrap_content`)

##Why do I want to Customize This Stuff
One day,I saw the built-in Weather App on my MIUI8 OS,all of its
layout and interface effect are very good-looking,but this type of
indicator is indeed rigid,didn't see any animations (may be,it's under another Layout,so can't see the effect when finished loading data?who knows...) , so I write for my own satisfaction.

Simple Reason.

## License

    Copyright 2015, gaoyuyu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
