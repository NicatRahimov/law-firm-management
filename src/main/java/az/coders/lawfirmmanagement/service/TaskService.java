package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.TaskDto;
import az.coders.lawfirmmanagement.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TaskService {

    List<Task>getAllTasks();
    Task getTaskById(Long id);

    String saveTask(Task task);

    String deleteTask(Long taskId);

    String editTask(Task task,Long taskId);
}
