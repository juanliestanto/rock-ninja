/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RockNinja.model;

/**
 *
 * @author user
 */
public interface Game {
    public int getSize();
    public int getPoints();
    public void setPosition(int x, int y);
    public void setVelocity(int x, int y) ;
    public int getX();
    public int getY();
    public void update(double time);
    public int getType();
    public boolean insideBounds(int x, int y) ;
}
