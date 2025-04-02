package study.practice.designPattern.proxy.Protection.implement;

public class ProtectedEmployee implements IEmployee{
    private IEmployee employee;

    public ProtectedEmployee(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public String getInfo(IEmployee viewer) {
        RESPONSIBILITY position = this.employee.getGrade();

        switch (viewer.getGrade()){
            case DIRECTOR:
                return this.employee.getInfo(viewer);
            case MANAGER:
                if(position != RESPONSIBILITY.DIRECTOR){
                    return this.employee.getInfo(viewer);
                }
            case STAFF:
                if(position != RESPONSIBILITY.DIRECTOR && position != RESPONSIBILITY.MANAGER){
                    return this.employee.getInfo(viewer);
                }
            default: return "다른 사람의 인사정보를 조회할 수 없습니다.";
        }
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public RESPONSIBILITY getGrade() {
        return employee.getGrade();
    }


}
