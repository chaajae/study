package study.practice.scheduler;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Monitoring {
    @Scheduled(cron = "0/10 * * * * *")
    public void diskMonitor(){
        try {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            File root = new File("/");
            System.out.printf("Disk Total : %s GB%n", toGB(root.getTotalSpace()));
            System.out.printf("Disk Usage : %s GB%n%n", toGB(root.getUsableSpace()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void cpuMonitor(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(com.sun.management.OperatingSystemMXBean.class);
        System.out.printf("CPU Usage : %.2f %%%n%n", mxBean.getCpuLoad() * 100);
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void memoryMonitor(){
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

        long heapInit = heap.getInit();
        long heapUsed = heap.getUsed();
        long heapCommitted = heap.getCommitted();
        long heapMax = heap.getMax();
        long nonHeapUsed = nonHeap.getUsed();

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.printf("Memory Init  : %s MB%n", toMB(heapInit));
        System.out.printf("Memory Usage : %s MB%n", toMB(heapUsed));
        System.out.printf("Memory Commit : %s MB%n", toMB(heapCommitted));
        System.out.printf("Memory Max : %s MB%n", toMB(heapMax));
        System.out.printf("Memory (Non Heap) Usage : %s MB%n", toMB(nonHeapUsed));
        System.out.printf("Memory Runtime : %s MB%n%n", toMB(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    public String toGB(long size) {
        return String.valueOf((int) (size / (1024 * 1024 * 1024)));
    }

    public String toMB(long size) {
        return String.valueOf((int) (size / (1024 * 1024)));
    }
}
