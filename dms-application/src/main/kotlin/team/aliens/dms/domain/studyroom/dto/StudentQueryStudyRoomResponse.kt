package team.aliens.dms.domain.studyroom.dto

import team.aliens.dms.domain.student.model.Sex
import team.aliens.dms.domain.studyroom.model.SeatStatus
import java.time.LocalTime
import java.util.UUID

data class StudentQueryStudyRoomResponse(
    val floor: Int,
    val timeSlots: List<TimeSlotElement>,
    val name: String,
    val totalAvailableSeat: Int,
    val inUseHeadcount: Int,
    val availableSex: Sex,
    val availableGrade: Int,
    val eastDescription: String,
    val westDescription: String,
    val southDescription: String,
    val northDescription: String,
    val totalWidthSize: Int,
    val totalHeightSize: Int,
    val seats: List<SeatElement>
) {

    data class SeatElement(
        val id: UUID,
        val widthLocation: Int,
        val heightLocation: Int,
        val number: Int?,
        val type: TypeElement?,
        val status: SeatStatus,
        val isMine: Boolean?,
        val student: StudentElement?,
    ) {

        data class TypeElement(
            val id: UUID,
            val name: String,
            val color: String
        )

        data class StudentElement(
            val id: UUID,
            val name: String
        )
    }

    data class TimeSlotElement(
        val id: UUID,
        val startTime: LocalTime,
        val endTime: LocalTime
    )
}
