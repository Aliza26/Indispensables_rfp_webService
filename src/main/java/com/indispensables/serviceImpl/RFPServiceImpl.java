package com.indispensables.serviceImpl;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indispensables.Entity.BidHeaderEntity;
import com.indispensables.Entity.BidSubmissionEntity;
import com.indispensables.Entity.BuyerEntity;
import com.indispensables.Entity.DocumentEntity;
import com.indispensables.Entity.DocumentHardCoded;
import com.indispensables.Entity.DocumentHeaderEntity;
import com.indispensables.Entity.RFPEntity;
import com.indispensables.Entity.VendorEntity;
import com.indispensables.Entity.VendorHeaderEntity;
import com.indispensables.Entity.VendorhardCoded;
import com.indispensables.Repository.BidHeaderRepo;
//import com.indispensables.Entity.VendorListHardCoded;
import com.indispensables.Repository.BuyerRepository;
import com.indispensables.Repository.DocumentHCodedRepo;

//import com.indispensables.Repository.DocumentHRepository;
import com.indispensables.Repository.DocumentHeaderRepo;
import com.indispensables.Repository.DocumentRepo;
//import com.indispensables.Repository.DocumentRepository;
import com.indispensables.Repository.RFPRepository;
import com.indispensables.Repository.VendorHCodedRepo;
import com.indispensables.Repository.VendorHeaderRepository;
import com.indispensables.Repository.VendorRepo;
//import com.indispensables.Repository.VendorhardCoded;
import com.indispensables.service.RFPService;
import com.indispensables.vo.BuyerVo;
import com.indispensables.vo.Document;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
import com.indispensables.vo.BidSubmission.BidVo;
@Service
public class RFPServiceImpl implements RFPService{

	@Autowired
	RFPRepository rfpRepo;
	@Autowired
	VendorHeaderRepository vendorHRepo;
	@Autowired
	VendorRepo venderRepo;
	@Autowired
	BuyerRepository buyerRepo;
	@Autowired
	DocumentRepo docRepo;
	@Autowired
	DocumentHeaderRepo docHRepo;
	@Autowired
	DocumentHCodedRepo documentHardCoded;
	int count = 1;
	@Autowired
	VendorHCodedRepo venHCodedRepo;
	@Autowired
	BidHeaderRepo bidHRepo;
	@Override
	public void save(RFPVo vo) {
		// TODO Auto-generated method stub
		RFPEntity rfpEntity = new RFPEntity();
		rfpEntity.setEstimatedPrice(vo.getEstimatedPrice());
		rfpEntity.setPublish(vo.isPublish());
		rfpEntity.setBidOpeningDate(vo.getBidOpeningDate());
		rfpEntity.setBidSubmissionDate(vo.getBidSubmissionDate());
		LocalDateTime now = LocalDateTime.now();
		rfpEntity.setRfpCreationDate(now);
		rfpEntity.setDraft(vo.isDraft());
		rfpEntity.setRemarks(vo.getRemarks());
		rfpEntity.setBuyer(buyerRepo.getById(vo.getBuyer()));
		rfpEntity.setSplitable(vo.isSplitable());
		rfpEntity.setName(vo.getName());
		//rfpEntity.setRfpId();
		VendorHeaderEntity vhe = new VendorHeaderEntity();
		vendorHRepo.save(vhe);
		DocumentHeaderEntity dhe = new DocumentHeaderEntity();
		dhe.setDocument_name(vo.getRemarks());
		count++;
		
		docHRepo.save(dhe);
		
	    rfpEntity.setRfp_id("MJ"+dhe.getId());

		BidHeaderEntity bhe = new BidHeaderEntity();
		bidHRepo.save(bhe);
		rfpEntity.setBidHeaderEntity(bhe);
		List<DocumentEntity> documentList = new ArrayList<>();
		for(int v :vo.getDoc()){
			DocumentHardCoded docEntity = documentHardCoded.getById(v);
			DocumentEntity docuEntity = new DocumentEntity();
			docuEntity.setDoc_id(dhe);
			docuEntity.setDocName(docEntity.getDocName());
			System.out.println(docEntity.getDocName());
			docRepo.save(docuEntity);
			documentList.add(docuEntity);
		}
		dhe.setDocument(documentList);

		rfpEntity.setDocumentHeaderEntity(dhe);
		List<VendorEntity> vendorList = new ArrayList<>();
		for(Vendor v :vo.getLi()) {
			System.out.println(v);
			VendorEntity vendorEntity = new VendorEntity();
			vendorEntity.setVendorHeaderId(vhe);
			vendorEntity.setVendorName(v.getName());
			venderRepo.save(vendorEntity);
			
			vendorList.add(vendorEntity);
		}
		vhe.setVendorsList(vendorList);
	
		rfpEntity.setVendorHeaderEntity(vhe);
		rfpRepo.save(rfpEntity);
	}
	@Override
	public List<RFPVo> getAllRFP(int buyerHeadId) {
		// TODO Auto-generated method stub
		List<RFPEntity> rfpEntity = rfpRepo.findByBuyerId(buyerHeadId); 
		List<RFPVo> rfpList = new ArrayList<>();
		
		for(RFPEntity rfp : rfpEntity) {
			RFPVo rfpvo = new RFPVo();
			rfpvo.setBidOpeningDate(rfp.getBidOpeningDate());
			rfpvo.setBidSubmissionDate(rfp.getBidSubmissionDate());
			rfpvo.setRfpCreationDate(rfp.getRfpCreationDate().toString());
			rfpvo.setDraft(rfp.isDraft());
			rfpvo.setId(rfp.getClient_id());
			rfpvo.setEstimatedPrice(rfp.getEstimatedPrice());
			rfpvo.setRemarks(rfp.getRemarks());
			rfpvo.setSplitable(rfp.isSplitable());
			rfpvo.setPublish(rfp.isPublish());
			rfpvo.setName(rfp.getName());
			rfpvo.setRfp_id(rfp.getRfp_id());
			List<String> listDocList = new ArrayList();
			for(DocumentEntity documentEntity : rfp.getDocumentHeaderEntity().getDocument()) {
				listDocList.add(documentEntity.getDocName());
			}
			rfpvo.setDocNameList(listDocList);
			List<String> vendoList = new ArrayList<>();
			for(VendorEntity vendorEntity : rfp.getVendorHeaderEntity().getVendorsList()) {
				vendoList.add(vendorEntity.getVendorName());
			}
			rfpvo.setVendoList(vendoList);
			rfpList.add(rfpvo);
		}
		return rfpList;
	}
	@Override
	public List<Vendor> getAllVendor(int rfpId) {
		// TODO Auto-generated method stub
		List<VendorEntity> VendorList = rfpRepo.getById(rfpId).getVendorHeaderEntity().
				getVendorsList();
		
		List<Vendor> li = new ArrayList<>();
		for(VendorEntity l : VendorList) {
			Vendor v = new Vendor();
			v.setId(l.getId());
			v.setName(l.getVendorName());
		}
		
		return li;
	}
	@Override
	public List<Vendor> getAllActiveVendor() {
		// TODO Auto-generated method stub
		List<VendorhardCoded> li = venHCodedRepo.findAll();
		List<Vendor> vendor = new ArrayList<>();
		System.out.println("hello");
		for(VendorhardCoded v : li) {
			if(v.isActive()) {
				Vendor ven = new Vendor();
				ven.setName(v.getVendorName());
				ven.setId(v.getId());
				vendor.add(ven);
			}
		}
		return vendor;
	}
	@Override
	public List<Document> getAllDocument() {
		// TODO Auto-generated method stub
		List<DocumentHardCoded> docList = documentHardCoded.findAll();
		
		List<Document> li = new ArrayList<>();
		for(DocumentHardCoded d : docList) {
			Document v = new Document();
			v.setId(d.getId());
			v.setName(d.getDocName());
			li.add(v);
		}
		
		return li;
	}
	@Override
	public RFPVo getRFPById(int rfpId) {
		// TODO Auto-generated method stub
		RFPEntity rfpEntity = rfpRepo.getById(rfpId);
		RFPVo rfpVo = new RFPVo();
		rfpVo.setBidOpeningDate(rfpEntity.getBidOpeningDate());
		rfpVo.setBidSubmissionDate(rfpEntity.getBidSubmissionDate());
		rfpVo.setBuyerName(rfpEntity.getBuyerName());
		rfpVo.setDraft(rfpEntity.isDraft());
		List<String> docList = new ArrayList<>();
		for(DocumentEntity d : rfpEntity.getDocumentHeaderEntity().getDocument()) {
			docList.add(d.getDocName());
		}
		rfpVo.setDocNameList(docList);
		rfpVo.setId(rfpEntity.getClient_id());
	//	rfpVo.setRfp_id(rfpEntity.getRfp_id());
		rfpVo.setEstimatedPrice(rfpEntity.getEstimatedPrice());
		rfpVo.setPublish(rfpEntity.isPublish());
		rfpVo.setRemarks(rfpEntity.getRemarks());
		List<String> venList = new ArrayList<>();
//		for(VendorEntity vendorEntity :rfpEntity.getVendorHeaderEntity().getVendorsList()) {
//			venList.add(vendorEntity.getVendorName());
//		}
		return rfpVo;
	}
	@Override
	public List<RFPVo> getAllRFPList() {
		// TODO Auto-generated method stub
        List<RFPVo> rfpList = new ArrayList<>();
		List<RFPEntity> rfpEntity = rfpRepo.findAll();
		for(RFPEntity rfp : rfpEntity) {
			RFPVo rfpvo = new RFPVo();
			rfpvo.setBidOpeningDate(rfp.getBidOpeningDate());
			rfpvo.setBidSubmissionDate(rfp.getBidSubmissionDate());
			rfpvo.setRfpCreationDate(rfp.getRfpCreationDate().toString());
			rfpvo.setDraft(rfp.isDraft());
			rfpvo.setId(rfp.getClient_id());
			rfpvo.setEstimatedPrice(rfp.getEstimatedPrice());
			rfpvo.setRemarks(rfp.getRemarks());
			rfpvo.setSplitable(rfp.isSplitable());
			rfpvo.setPublish(rfp.isPublish());
			List<String> listDocList = new ArrayList();
			for(DocumentEntity documentEntity : rfp.getDocumentHeaderEntity().getDocument()) {
				listDocList.add(documentEntity.getDocName());
			}
			rfpvo.setDocNameList(listDocList);
			List<String> vendoList = new ArrayList<>();
			for(VendorEntity vendorEntity : rfp.getVendorHeaderEntity().getVendorsList()) {
				vendoList.add(vendorEntity.getVendorName());
			}
			rfpvo.setVendoList(vendoList);
			rfpList.add(rfpvo);
		}
		return rfpList;
	}
//	@Override
//	public RFPVo getRFPById(String id) {
//		// TODO Auto-generated method stub
//		RFPVo rfpVo = new RFPVo();
//		RFPEntity rfpEntity = rfpRepo.findById(id);
//		rfpVo.setBidOpeningDate(rfpEntity.getBidOpeningDate());
//		rfpVo.setBidSubmissionDate(rfpEntity.getBidSubmissionDate());
//		rfpVo.setBuyerName(rfpEntity.getBuyerName());
//		List<String> listDocList = new ArrayList();
//		for(DocumentEntity documentEntity : rfpEntity.getDocumentHeaderEntity().getDocument()) {
//			listDocList.add(documentEntity.getDocName());
//		}
//		rfpVo.setDocNameList(listDocList);
//		return rfpVo;
//	}
	@Override
	public List<BidVo> getAllBids(int id) {
		// TODO Auto-generated method stub
		List<BidSubmissionEntity> bidSubEntity = rfpRepo.getById(id).getBidHeaderEntity().getBid();
		List<BidVo> bidVo = new ArrayList<>();
		for(BidSubmissionEntity be : bidSubEntity) {
			BidVo bv = new BidVo();
			bv.setActive(be.isActive());
			if(be.getBidCreationDateTime() != null) {
			bv.setBidCreationDateTime(be.getBidCreationDateTime().toString());
			}
			bv.setBidId(be.getBidSubId());
			if(be.getBidOpeningDateTime() != null) {
			bv.setBidOpeningDateTime(be.getBidOpeningDateTime().toString());
			}
			bv.setBidPrice(be.getBidPrice());
			bv.setBidStatus(be.isBidStatus());
			if(be.getBidSubmissionDateTime() != null) {
			bv.setBidSubmissionDateTime(be.getBidSubmissionDateTime().toString());
			}
			bv.setDraft(be.isDraft());
			bv.setRemarks(be.getRemarks());
			bv.setVendorName(be.getVendorName());
			bidVo.add(bv);
		}
		return bidVo;
	}
	@Override
	public RFPVo findRFPById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
