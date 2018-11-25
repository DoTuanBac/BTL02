/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Do Tuan Bac
 */
public class Animation {

    private String name;                //Tên ảnh
    private boolean isRepeated;            //Lặp lại
    private ArrayList<FrameImage> framImages;    //Chứa hình ảnh
    private int currentFrame;       //Biến đang lưu giữ
    private ArrayList<Boolean> ignoreFrames;    //Bỏ thừa
    private ArrayList<Double> delayFrames;      //Từ frame1 đến frame2 tốn bao lâu
    private long beginTime;
    private boolean drawRectFrame;

    public Animation() {
        delayFrames = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;
        ignoreFrames = new ArrayList<>();
        framImages = new ArrayList<>();
        drawRectFrame = false;
        isRepeated = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public ArrayList<FrameImage> getFramImages() {
        return framImages;
    }

    public void setFramImages(ArrayList<FrameImage> framImages) {
        this.framImages = framImages;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if (currentFrame >= 0 && currentFrame < framImages.size()) {
            this.currentFrame = currentFrame;
        } else {
            this.currentFrame = 0;
        }
    }

    public ArrayList<Boolean> getIgnoreFrames() {
        return ignoreFrames;
    }

    public void setIgnoreFrames(ArrayList<Boolean> ignoreFrames) {
        this.ignoreFrames = ignoreFrames;
    }

    public ArrayList<Double> getDelayFrames() {
        return delayFrames;
    }

    public void setDelayFrames(ArrayList<Double> delayFrames) {
        this.delayFrames = delayFrames;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean isDrawRectFrame() {
        return drawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        this.drawRectFrame = drawRectFrame;
    }

    public boolean isIgnoreFrame(int id) {
        return ignoreFrames.get(id);
    }

    public void setIgnoreFrame(int id) {
        if (id > 0 && id < ignoreFrames.size()) {
            ignoreFrames.set(id, true);
        }
    }

    public void unIgnoreFrame(int id) {
        if (id > 0 && id < ignoreFrames.size()) {
            ignoreFrames.set(id, false);
        }
    }

    public void reset() {
        currentFrame = 0;
        beginTime = 0;
        for (int i = 0; i < ignoreFrames.size(); i++) {
            ignoreFrames.set(i, false);
        }
    }

    public void add(FrameImage frameImage, double timeToNextFrame) {
        ignoreFrames.add(false);
        framImages.add(frameImage);
        delayFrames.add(timeToNextFrame);
    }

    public BufferedImage getCurrentImage() {
        return framImages.get(currentFrame).getImage();
    }

    public void nextFrame() {
        if (currentFrame >= framImages.size() - 1) {
            if (isRepeated) {
                currentFrame = 0;
            }
        } else {
            currentFrame++;
        }
        if (ignoreFrames.get(currentFrame)) {
            nextFrame();
        }
    }

    public void Update(long currentTime) {
        if (beginTime == 0) {
            beginTime = currentTime;
        } else {
            if (currentTime - beginTime > delayFrames.get(currentFrame)) {
                nextFrame();
                beginTime = currentTime;
            }
        }
    }

    public boolean isLastFrame() {
        if (currentFrame == framImages.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(int x, int y, Graphics2D g2) {
        BufferedImage image = getCurrentImage();
        g2.drawImage(image, x, y, null);
        if (drawRectFrame) {
            g2.drawRect(0, 0, 0, 0);
        }

    }

}
