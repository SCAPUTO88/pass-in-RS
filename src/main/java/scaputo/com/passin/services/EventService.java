package scaputo.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import scaputo.com.passin.domain.attendee.Attendee;
import scaputo.com.passin.domain.event.Event;
import scaputo.com.passin.dto.event.EventResponseDTO;
import scaputo.com.passin.repositories.AttendeeRepository;
import scaputo.com.passin.repositories.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDTO getEventDetail(String eventId){
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID:" + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }

}
