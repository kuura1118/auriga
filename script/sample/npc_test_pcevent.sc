//=====================================================================
// �� OnPC�C�x���g���x�� �e�X�g�X�N���v�g
//						created by Rayce
//�@���Fbattle_auriga.conf�ŊY���̍��ڂ�L��������
//�@�@�@���p���Ă��������B
//---------------------------------------------------------------------

//---------------------------------------------------------------------
//��2F�ł̂ݎ��S������A�C�e����S���������

gl_cas02.gat,0,0,0	script	DieControl	-1,{
OnPCDie:
	clearitem;
	end;
}


//---------------------------------------------------------------------
//MAP���œ|�����l����Ԃ�

pvp_y_1-1.gat,155,192,4	script	�L�^��	711,{
	mes "[�L�^��]";
	mes "���Ȃ����|�����l����";
	mes "^3355FF" +@pvcount+ " ^000000�l�ł��B";
	close;
OnPCKill:
	set '@aid,getcharid(3,getcharname(PC_KILLED_CHAR));
	if(attachrid('@aid)) {
		set @pvcount,@pvcount+1;	//�E��������̃J�E���^�����Z����
		detachrid;
	}
	end;
}


//---------------------------------------------------------------------
//�v���C���[��MAP�Ɋւ�炸���O�C���E���O�A�E�g���ɃA�i�E���X�������
//����������NPC��ݒu����MAP�T�[�o���Ɍ���

-	script	Login/Logout	-1,{
	function Area {
		set '@name$,substr(getarg(0),0,3);
		if('@name$ == "prt" || '@name$ == "pro")
			return "�v�����e��";
		if('@name$ == "gef")
			return "�Q�t�F��";
		if('@name$ == "moc" || '@name$ == "mor")
			return "�����N";
		if('@name$ == "pay")
			return "�t�F�C����";
		else
			return "���̑���";
	}
OnPCLogin:
	announce strcharinfo(0)+ "����" +Area(getmapname(strcharinfo(0)))+ "�G���A�Ƀ��O�C�����܂���",8,0xDDA0DD;
	end;
OnPCLogout:
	announce strcharinfo(0)+ "����" +Area(getmapname(strcharinfo(0)))+ "�G���A�Ń��O�A�E�g���܂���",8,0xDDA0DD;
	end;
}


//---------------------------------------------------------------------
//�v�����e���A�C�Y���[�h�A�A���x���^��K�ꂽ�̂אl����Ԃ�
//������3��NPC�������MAP�T�[�o�ɑ��݂���Ƃ��̂ݓ��삪�ۏ؂����

prontera.gat,146,92,6	script	�ό��n�ē�#pro	114,{
	set '@total,'count + getvariableofnpc('count,"�ό��n�ē�#izl") + getvariableofnpc('count,"�ό��n�ē�#alb");
	mes "[�ό��n�ē�]";
	mes "�����v�����e����K�ꂽ�l��";
	mes "�̂� ^3355FF" +'count+ " ^000000�l�ł��B";
	mes "�C�Y���[�h�ƃA���x���^�����킹���";
	mes "���v^3355FF " +'@total+ " ^000000�l�ƂȂ�܂��B";
	close;
OnPCMoveMap:
	set 'count,'count+1;
	end;
}

izlude.gat,134,91,4	script	�ό��n�ē�#izl	114,{
	set '@total,'count + getvariableofnpc('count,"�ό��n�ē�#pro") + getvariableofnpc('count,"�ό��n�ē�#alb");
	mes "[�ό��n�ē�]";
	mes "�����C�Y���[�h��K�ꂽ�l��";
	mes "�̂� ^3355FF" +'count+ " ^000000�l�ł��B";
	mes "�v�����e���ƃA���x���^�����킹���";
	mes "���v^3355FF " +'@total+ " ^000000�l�ƂȂ�܂��B";
	close;
OnPCMoveMap:
	set 'count,'count+1;
	end;
}

alberta.gat,113,57,6	script	�ό��n�ē�#alb	114,{
	set '@total,'count + getvariableofnpc('count,"�ό��n�ē�#pro") + getvariableofnpc('count,"�ό��n�ē�#izl");
	mes "[�ό��n�ē�]";
	mes "�����A���x���^��K�ꂽ�l��";
	mes "�̂� ^3355FF" +'count+ " ^000000�l�ł��B";
	mes "�v�����e���ƃC�Y���[�h�����킹���";
	mes "���v^3355FF " +'@total+ " ^000000�l�ƂȂ�܂��B";
	close;
OnPCMoveMap:
	set 'count,'count+1;
	end;
}