package org.derekisbusy.jarduino.game;

import org.sintef.jarduino.AnalogPin;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.JArduinoCom;
import org.sintef.jarduino.ProtocolConfiguration;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class JArduinoGame extends JArduino implements ApplicationListener {

	final static boolean debug = true;
	short analog0;
	short analog1;
	
	/*
	 * JArduino
	 */
	

	public JArduinoGame(String ID, JArduinoCom com) {
        super(ID, com, null);
    }

    public JArduinoGame(JArduinoCom com) {
        super(null, com, null);
    }

    public JArduinoGame(String ID, JArduinoCom com, ProtocolConfiguration prot) {
        super(ID, com, prot);
    }

    public JArduinoGame(JArduinoCom com, ProtocolConfiguration prot) {
        super(null, com, prot);
    }

    public JArduinoGame() {
        super(null, JArduinoCom.Serial, null); //Serial by default
    }

    public JArduinoGame(String id) {
        super(id, JArduinoCom.Serial, null); //Serial by default
    }
    
    
    
    /**
     * LibGDX Interface
     */
    
	protected Screen screen;
	@Override
	public void dispose () {
		if (screen != null) screen.hide();
	}

	@Override
	public void pause () {
		if (screen != null) screen.pause();
	}

	@Override
	public void resume () {
		if (screen != null) screen.resume();
	}

	@Override
	public void render () {
		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize (int width, int height) {
		if (screen != null) screen.resize(width, height);
	}

	/** Sets the current screen. {@link Screen#hide()} is called on any old screen, and {@link Screen#show()} is called on the new
	 * screen, if any.
	 * @param screen may be {@code null} */
	public void setScreen (Screen screen) {
		if (this.screen != null) this.screen.hide();
		this.screen = screen;
		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}

	/** @return the currently active {@link Screen}. */
	public Screen getScreen () {
		return screen;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loop() {
		readPins();
	}

	public void println(String out) {
		if (JArduinoGame.debug)
			System.out.println(out);
	}
	
	public void readPins()
	{
		this.analog0 = analogRead(AnalogPin.A_0);
		this.analog1 = analogRead(AnalogPin.A_1);
	}
	
	public boolean buttonPressed()
	{
		if(analog0 > 10)
			return true;
		if(analog1 > 10)
			return true;
		return false;
	}
	
	public boolean isPressed(AnalogPin pin)
	{
		switch(pin) {
		case A_0:
			if(analog0 > 10)
				return true;
		case A_1:
			if(analog1 > 10)
				return true;
			break;
		case A_2:
			break;
		case A_3:
			break;
		case A_4:
			break;
		case A_5:
			break;
		default:
			break;
		}
		return false;
	}
	
	
	/***********************************
	 * 		Getters and setters
	 ***********************************/
	

    public short getAnalog0() {
		return analog0;
	}

	public void setAnalog0(short analog0) {
		this.analog0 = analog0;
	}
	
    public short getAnalog1() {
		return analog1;
	}

	public void setAnalog1(short analog1) {
		this.analog1 = analog1;
	}
	
}
