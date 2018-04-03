# AndroidLooper

### Definition
Class used to run a message loop for a thread

### Why use
Normal thread **can not** reuse after it finish.
- Normal thread will destroyed after `run()` function finish
- Thread is destroyed can not start again (we will get `java.lang.IllegalThreadStateException: Thread already started`)

=> For execute 10 tasks, you may need to create 10 threads.
Create many threads may not good => use can use `Looper` and reused this thread

### Using

Inside a Thread we will create a `Looper` and a `Handler`
- `Looper` make this class alive for long time (not destroyed after run)
- `Handler` use to communicate with this `Thread`

We will use `Handler` to send task to the thread use method `post()` => and then tasks will execute sequence (thread-safe)

### Note
`Looper` can make thread alive using very simple way like :D

    public static void loop() {
         for (;;) {
         ...
         }
    }

### Popular using

In Android, `Looper` is used for main thread

### Current thinking (may update in future if I have more knowledge :D)

Currently, I think that `Looper` may equals `ThreadPoolExecutor` which have 1 core thread and maximum  thread is 1. Because thread in `ThreadPoolExecutor` also alive long time (it is not exist after finished run()) and it also can handle multiple task sequence
