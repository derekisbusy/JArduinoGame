# JArduinoGame

(BETA)

Classes to help integrate JArduino and LibGDX

These classes require [JArduino](https://github.com/SINTEF-9012/JArduino) and [LibGDX](https://github.com/libgdx/libgdx).

This class currently only works with Desktop version of LibGDX games.

To use this class with your LibGDX game repace the LibGDX Game class that your game extends from with the JArduinoGame class.

You will need to add a constructor to your game class that sets to serial port and calls the runArduinoProcess method. E.g.

```java
public MyGame(String serialPort) {
		super(serialPort);
		this.runArduinoProcess();
}
```

If you want to be able to select a serial port when the game launches you will have to add the JArduino serial port selector to your desktop launcher. E.g.

```java
public class DesktopLauncher {
	public static void main (String[] arg) {
		String serialPort;
		if (arg.length == 1) {
			serialPort = arg[0];
		} else {
			serialPort = Serial4JArduino.selectSerialPort();
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "My Game";
		config.width = 480;
		config.height = 800;
		new LwjglApplication( new MyGame(serialPort), config);
	}
}
```
