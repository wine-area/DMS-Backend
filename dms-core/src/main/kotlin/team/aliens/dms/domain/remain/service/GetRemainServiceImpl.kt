package team.aliens.dms.domain.remain.service

import team.aliens.dms.common.annotation.Service
import team.aliens.dms.domain.remain.exception.RemainAvailableTimeNotFoundException
import team.aliens.dms.domain.remain.exception.RemainOptionNotFoundException
import team.aliens.dms.domain.remain.exception.RemainStatusNotFound
import team.aliens.dms.domain.remain.model.RemainOption
import team.aliens.dms.domain.remain.spi.QueryRemainAvailableTimePort
import team.aliens.dms.domain.remain.spi.QueryRemainOptionPort
import team.aliens.dms.domain.remain.spi.QueryRemainStatusPort
import java.util.UUID

@Service
class GetRemainServiceImpl(
    private val queryRemainAvailableTimePort: QueryRemainAvailableTimePort,
    private val queryRemainOptionPort: QueryRemainOptionPort,
    private val queryRemainStatusPort: QueryRemainStatusPort
) : GetRemainService {

    override fun getRemainAvailableTimeBySchoolId(schoolId: UUID) =
        queryRemainAvailableTimePort.queryRemainAvailableTimeBySchoolId(schoolId)
            ?: throw RemainAvailableTimeNotFoundException

    override fun getRemainOptionById(remainOptionId: UUID) =
        queryRemainOptionPort.queryRemainOptionById(remainOptionId) ?: throw RemainOptionNotFoundException

    override fun getAllRemainOptionsBySchoolId(schoolId: UUID) =
        queryRemainOptionPort.queryAllRemainOptionsBySchoolId(schoolId)

    override fun getAllRemainStatusInfoByStudentId(studentIds: List<UUID>) =
        queryRemainStatusPort.queryAllByStudentId(studentIds)

    override fun getRemainStatusById(studentId: UUID) =
        queryRemainStatusPort.queryRemainStatusById(studentId)

    override fun getAppliedRemainOptionByStudentId(studentId: UUID): RemainOption {
        val remainStatus = getRemainStatusById(studentId) ?: throw RemainStatusNotFound
        return getRemainOptionById(remainStatus.remainOptionId)
    }
}
