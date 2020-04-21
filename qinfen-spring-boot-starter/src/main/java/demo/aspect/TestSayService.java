package demo.aspect;

import org.springframework.stereotype.Service;

@Service
public class TestSayService {
    public void saying(String args) {
        System.out.println("saying " + args);
    }
}
