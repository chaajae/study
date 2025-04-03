package study.practice.designPattern.decorator.weapon;

public class BaseWeapon implements Weapon{
    @Override
    public void aim_and_fire() {
        System.out.println("총알 발사");
    }
}
