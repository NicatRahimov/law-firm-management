package az.coders.lawfirmmanagement.service.Impl;

import az.coders.lawfirmmanagement.exception.TaskNotFound;
import az.coders.lawfirmmanagement.model.Task;
import az.coders.lawfirmmanagement.repository.TaskRepository;
import az.coders.lawfirmmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
       return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
       return taskRepository.findById(id).orElseThrow(()->new TaskNotFound("Task not found"));
    }

    @Override
    public String saveTask(Task task) {
        taskRepository.save(task);
        return "Saved successfully";
    }

    @Override
    public String deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFound("Task not found with this id:"+taskId));
        taskRepository.delete(task);
        return "Deleted successfully";
    }

    @Override
    public String editTask(Task task, Long taskId) {
        Task task1 = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFound("Task not found"));

        task1.setName(task.getName());
        task1.setDescription(task.getDescription());
        task1.setPriority(task.getPriority());
        task1.setACase(task.getACase());

        taskRepository.save(task1);

        return "Edited successfully";

    }
}