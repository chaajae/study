package study.practice.designPattern.decorator.weapon;

public abstract class WeaponAccessory implements Weapon{
    private Weapon rifle;

    public WeaponAccessory(Weapon rifle) {
        this.rifle = rifle;
    }

    @Override
    public void aim_and_fire() {
        rifle.aim_and_fire();
    }
}
