package com.example.OSFInalProject;

import com.example.OSFInalProject.BestFit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Memory> memoryList = new ArrayList<Memory>();
        List<Job> jobList = new ArrayList<Job>();
        List<BestFit> bestFits = new ArrayList<BestFit>();
        int Size = 10;
        Random r = new Random();
        for (int i = 0; i<Size; i++){
            int low = 100;
            int high = 5000;
            Memory memory = new Memory(r.nextInt(high-low) + low);
            memoryList.add(memory);
            if (i < 5) {
                low = 10;
                high = 4000;
                Job job = new Job(r.nextInt(high - low) + low);
                jobList.add(job);
            }
        }
        memoryList.sort(new MemoryComp());
        jobList.sort(new JobComp());
        for (Memory memory :memoryList)
            System.out.println(memory.toString());
        for (Job job : jobList)
            System.out.println(job.toString());
        BestFit bestFit = new BestFit();
        bestFits = bestFit.bestFits(jobList,memoryList);
        for (BestFit bestFit1 : bestFits)
            System.out.println(bestFit1.toString());
        for (Memory memory :memoryList)
            System.out.println(memory.toString());
        int memory = 0, jobsize = 0, II = 0;
        for (BestFit bestFit2 : bestFits){
            memory+=bestFit2.getMemorySize();
            jobsize+=(bestFit2.getMemorySize() - bestFit2.getInternalFragmentation());
            II+=bestFit2.getInternalFragmentation();
        }

        request.setAttribute("bestFits",bestFits);
        request.setAttribute("memoryList",memoryList);
        request.setAttribute("jobList",jobList);

        System.out.println(
                "Total memory :" + memory + "\n" +
                        "Total job size :" + jobsize + "\n" +
                        "Total InternalFragmentation :" + II + "\n"
        );
        request.setAttribute("memory",memory);
        request.setAttribute("jobsize",jobsize);
        request.setAttribute("II",II);

        request.getRequestDispatcher("bestfit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reference_string = request.getParameter("string");
        int frame = Integer.parseInt(request.getParameter("frame"));
        SecondCh secondCh = new SecondCh();
        int res = secondCh.calculateFaults(reference_string,frame);
        request.setAttribute("res",res);
        request.getRequestDispatcher("second.jsp").forward(request,response);
    }

    public void destroy() {
    }
}