package study.practice.designPattern.decorator.weapon;

public class Grenade extends WeaponAccessory{
    public Grenade(Weapon rifle) {
        super(rifle);
    }

    @Override
    public void aim_and_fire() {
        super.aim_and_fire();
        grenade_fire();
    }

    public void grenade_fire(){
        System.out.println("유탄 발사");
    }
}
