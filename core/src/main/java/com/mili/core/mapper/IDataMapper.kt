package com.mili.core.mapper

interface IDataMapper<Entity,Domain> {

    fun mapEntityToDomain(entity: Entity):Domain

    fun mapDomainToEntity(domain: Domain): Entity
}