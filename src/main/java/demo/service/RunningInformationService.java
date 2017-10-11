package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation);
    Page<RunningInformation> findAllByOrderByHealthWarningLevel(Pageable pageable);
    void deleteByRunningId(String runningId);
}