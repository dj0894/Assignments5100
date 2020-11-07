package reverse_hello.multithreading;


class ReverseHello extends Thread{
        int counter;
        public ReverseHello(int counter){
            this.counter=counter;
        }
        public void run()
        {
            if(counter<50)
            {
                createThread(counter+1);
            }
            System.out.println("Hello from Thread " + counter+"!");
        }
        public void createThread(int counter) {
            ReverseHello thread=new ReverseHello(counter);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] arg){
            ReverseHello thread = new ReverseHello(1);
            thread.start();
        }

}

