# GodotCamera
- Native Camera support on Godot engine for Android. (https://github.com/thiagobruno/GodotCamera)

- Godot version 2.1.5 stable.

## How to use
- Download source Godot 2.1.5 stable "godot-2.1.5-stable.tar.xz" (https://downloads.tuxfamily.org/godotengine/2.1.5/).

- Drop the ```module/GodotCamera``` folder inside ```godot/modules```

- Move the ```module/GodotCamera.java``` to ```godot/platform/android/java/src/org/godotengine/godot```

### Compile
1. #> scons platform=android
2. cd godot/platform/android/java
3. #> ./gradlew build
4. The custom apk will be available at ```godot/bin```, ```android_debug.apk``` and ```android_release.apk```
 
### Configure
Add the following in the engine.cfg file:

> [android]
> modules="org/godotengine/godot/GodotCamera"

### Example
See the example to learn more about how it works

### Export
> Export->Target->Android

Custom Package (Debug/Release): 
> Point to the newly built apk

> Permission check: CAMERA, READ/WRITE _EXTERNAL_STORAGE

### Common Errors
- You open the game, and it locks and closes: ```Check the above permissions```

### TODO
- Camera preview in scene or object like a TextureFrame, Sprite or other.
- Fix rotate camera
- Auto-Taken after seconds or face-dectect
- Loader
- Picture Resize / Quality
- AI / Face detect, recognize

####License
MIT

###Special Mention
Thanks [TeamGeraçãoWeb](http://geracaoweb.com)

