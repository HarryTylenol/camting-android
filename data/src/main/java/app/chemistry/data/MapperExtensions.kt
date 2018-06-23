package app.chemistry.data

import app.chemistry.data.model.AuthData
import app.chemistry.data.model.CamtingData
import app.chemistry.domain.auth.AuthDomain
import app.chemistry.domain.camting.CamtingDomain

fun CamtingData.toDomain() = CamtingDomain(id, name, memberCount)
fun CamtingDomain.toData() = CamtingData(id, name, memberCount)

fun AuthData.toDomain() = AuthDomain(uid, phoneNumber)
fun AuthDomain.toData() = AuthData(uid, phoneNumber)