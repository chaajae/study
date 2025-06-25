//package study.practice.gui;
//
//import com.sun.management.OperatingSystemMXBean;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.File;
//import java.lang.management.ManagementFactory;
//
//@Slf4j
//@Component // 실행순서 4. Spring이 Bean으로 등록
//public class UsageMonitor { // 실행순서 3. 생성자 암묵적으로 실행
//    // 실행순서 2. 필드 초기화
//    private JFrame frame = new JFrame("Usage Monitor");
//    private JButton heapMax = new JButton();
//    private JButton heapCommit = new JButton();
//    private JButton heapUse = new JButton();
//    private JButton diskTotal = new JButton();
//    private JButton diskUse = new JButton();
//    private JButton cpu = new JButton();
//
//    // 실행순서 1. JVM이 클래스를 로딩하는 시점에 static 블럭 딱 한번만 실행 (Bean으로 등록전)
//    static {
//        System.setProperty("java.awt.headless", "true"); // JFrame 초기화시 에러 방지
//    }
//
//    // 실행순서 5. Spring이 Bean으로 등록된 직후 바로 실행됨
//    // 인스턴스화 직후에 실행 시키려고 붙이는 어노테이션인데 Bean등록 안되어있으면 인스턴스화 직후에 실행안됨
//    //@PostConstruct
//    public void monitor() {
//        try {
//            frame.add(heapMax);
//            frame.add(diskTotal);
//            frame.add(heapCommit);
//            frame.add(diskUse);
//            frame.add(heapUse);
//            frame.add(cpu);
//
//            frame.setBounds(800 , 100, 600, 150);
//            frame.setLayout(new GridLayout(3, 6));
//            frame.setAlwaysOnTop(true); // 다른 창 눌러도 뒤로 안감
//
//            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//            // 닫기 눌렀을때 한번 더 물어봄
//            frame.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosing(WindowEvent e) {
//                    int result = JOptionPane.showConfirmDialog(
//                            frame,
//                            "Close?",
//                            "Close",
//                            JOptionPane.YES_NO_OPTION
//                    );
//                    if (result == JOptionPane.YES_OPTION) {
//                        frame.dispose();
//                    }
//                }
//            });
//
//            frame.setVisible(true);
//            heapMax.setText(getHeapMax());
//            heapCommit.setText(getHeapCommit());
//            heapUse.setText(getHeapUsage());
//            diskTotal.setText(getDiskTotal());
//            diskUse.setText(getDiskUsage());
//            cpu.setText(getCpuUsage());
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//    }
//
//    @Scheduled(cron = "0/1 * * * * *")
//    public void setHeapUsage(){
//        heapUse.setText(getHeapUsage());
//    }
//
//    @Scheduled(cron = "0/1 * * * * *")
//    public void setHeapCommit(){
//        heapCommit.setText(getHeapCommit());
//    }
//
//    public String getHeapMax(){
//        return String.format("Heap Max : %s MB",toMB(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax()));
//    }
//
//    public String getHeapCommit(){
//        return String.format("Heap Commit : %s MB",toMB(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getCommitted()));
//    }
//
//    public String getHeapUsage(){
//        return String.format("Heap Usage : %s MB",toMB(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed()));
//    }
//
//    @Scheduled(cron = "0/1 * * * * *")
//    public void setDiskUsage(){
//        diskUse.setText(getDiskUsage());
//    }
//
//    public String getDiskTotal(){
//        return String.format("Disk Total : %s GB",toGB(new File("/").getTotalSpace()));
//    }
//
//    public String getDiskUsage(){
//        return String.format("Disk Usage : %s GB",toGB(new File("/").getUsableSpace()));
//    }
//
//    @Scheduled(cron = "0/1 * * * * *")
//    public void setCpuUsage(){
//        cpu.setText(getCpuUsage());
//    }
//
//    public String getCpuUsage(){
//        OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        return String.format("Cpu Usage : %.2f %%", mxBean.getCpuLoad() * 100);
//    }
//
//    public String toGB(long size) {
//        return String.valueOf((int) (size / (1024 * 1024 * 1024)));
//    }
//
//    public String toMB(long size) {
//        return String.valueOf((int) (size / (1024 * 1024)));
//    }
//}
