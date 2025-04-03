package study.practice.designPattern.decorator.weapon;

public class Scoped extends WeaponAccessory{
    public Scoped(Weapon rifle) {
        super(rifle);
    }

    @Override
    public void aim_and_fire() {
        aiming();
        super.aim_and_fire();
    }

    public void aiming(){
        System.out.println("조준중");
    }
}
