package org.example.models;

public class Light extends Thing {

    public interface OnLightChangedListener {
        void onLightChanged(Light light);
    }

    private OnLightChangedListener lightChangedListener;
    private boolean isLightOn = false;

    @Override
    public String getTypeName() {
        return "Light";
    }

    @Override
    public String getDescription() {
        return "isLightOn = " + isLightOn;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
        if(lightChangedListener != null){
            lightChangedListener.onLightChanged(this);
        }
    }

    public void setOnLightChangedListener(OnLightChangedListener onLightChangedListener) {
        this.lightChangedListener = onLightChangedListener;
    }
}
