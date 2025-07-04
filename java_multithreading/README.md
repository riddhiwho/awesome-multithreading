To create a new thread in java, you can either extend the Thread class or implement the Runnable interface.

3. What’s the Difference?

| Aspect                     | Extending `Thread`                                                          | Implementing `Runnable`                                                 |
| -------------------------- | --------------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| **Inheritance**            | You can’t extend any other class (Java allows only **single inheritance**). | You can extend another class, since you’re not extending `Thread`.      |
| **Separation of concerns** | Thread logic and thread object are **coupled**.                             | You separate the **task (Runnable)** from the **thread (Thread)**.      |
| **Reusability**            | Harder to reuse the code for logic independently.                           | More reusable — your logic is independent of thread management.         |
| **Common practice**        | Less preferred in modern Java.                                              | Preferred in real-world apps, especially in executors and thread pools. |


Lifecycle of a thread:

1. New: when thread is created but not yet started.
2. Runnable: After the start method is called, the thread becomes runnable. It's ready to run and is waiting for CPU time.
3. Running: when the thread is executing.
4. Blocked/Waiting: Waiting for a resource or for another thread to perform a task.
5. Terminated: finished executing.