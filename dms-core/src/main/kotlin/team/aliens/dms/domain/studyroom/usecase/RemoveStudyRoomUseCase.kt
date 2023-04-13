package team.aliens.dms.domain.studyroom.usecase

import team.aliens.dms.common.annotation.UseCase
import team.aliens.dms.common.spi.SecurityPort
import team.aliens.dms.domain.school.validateSameSchool
import team.aliens.dms.domain.studyroom.exception.StudyRoomNotFoundException
import team.aliens.dms.domain.studyroom.spi.CommandStudyRoomPort
import team.aliens.dms.domain.studyroom.spi.QueryStudyRoomPort
import team.aliens.dms.domain.user.exception.UserNotFoundException
import team.aliens.dms.domain.user.spi.QueryUserPort
import java.util.UUID

@UseCase
class RemoveStudyRoomUseCase(
    private val queryStudyRoomPort: QueryStudyRoomPort,
    private val commandStudyRoomPort: CommandStudyRoomPort,
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(studyRoomId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()
        val manager = queryUserPort.queryUserById(currentUserId) ?: throw UserNotFoundException

        val studyRoom = queryStudyRoomPort.queryStudyRoomById(studyRoomId) ?: throw StudyRoomNotFoundException
        validateSameSchool(studyRoom.schoolId, manager.schoolId)

        commandStudyRoomPort.deleteStudyRoomTimeSlotByStudyRoomId(studyRoomId)
        commandStudyRoomPort.deleteSeatApplicationByStudyRoomId(studyRoomId)
        commandStudyRoomPort.deleteSeatByStudyRoomId(studyRoomId)
        commandStudyRoomPort.deleteStudyRoomById(studyRoomId)
    }
}
